import React, {Component} from 'react';
import Loader from './Loader/Loader';
import Table from './Table/Table';
import sort from 'lodash';
import PaymentTable from './Card-Details/DetailsTable';
import Header from './Header/Header';
import Income from './IncomeModal/Income';
import Payment from './New-Payment-Modal/NewPaymentModal';


//TODO after server-side:
//TODO fetch to save btn-s
//TODO onclick to block and rename table headers
//TODO authorisation ??
//TODO sort-direction icon??

class App extends Component {

	state = {
		isLoading: true,
		data: [],
		sort: 'asc', //def
		sortField: 'id',//def
		row: null, //selected card, null case - all cards list
		newPaymentModalOn: false,
		incomeModalOn: false,
		selectedCardNumber: 'Select Card!',
		costValue: 0,
		description: '',
		cmp : 'Loader'
	};

	//after load DOM
	async componentDidMount() {
		//add get (Mock for test?? mb)
		//const response = await fetch(``);
		//const data = await response.json();
		//cardnumber - regexp
		const data = [
			{
				cardNumber: 'visa-4444', balance: 1, expense: 2, block: false,
				payments: [
					{date: '12-06-2019', number: 12, cost: 5, description: 'Phone'},
					{date: '12-06-2019', number: 12, cost: 5, description: 'Phone'},
					{date: '12-06-2019', number: 12, cost: 5, description: 'Phone'}
				]
			},
			{
				cardNumber: 'visa-4443', balance: 2, expense: 12, block: false,
				payments: [
					{date: '12-06-2019', number: 12, cost: 5, description: 'Phone'},
					{date: '12-06-2019', number: 12, cost: 5, description: 'Phone'},
					{date: '12-06-2019', number: 12, cost: 5, description: 'Phone'}
				]
			},
			{
				cardNumber: 'visa-4442', balance: 3, expense: 22, block: true,
				payments: [
					{date: '12-06-2019', number: 12, cost: 5, description: 'Phone'},
					{date: '12-06-2019', number: 12, cost: 5, description: 'Phone'},
					{date: '12-06-2019', number: 12, cost: 5, description: 'Phone'}
				]
			},
			{
				cardNumber: ' visa-4441', balance: 4, expense: 32, block: false,
				payments: [
					{date: '12-06-2019', number: 12, cost: 5, description: 'Phone'},
					{date: '12-06-2019', number: 12, cost: 5, description: 'Phone'},
					{date: '12-06-2019', number: 12, cost: 5, description: 'Phone'}
				]
			},
			{
				cardNumber: 'visa-4445', balance: 6, expense: 42, block: true,
				payments: [
					{date: '12-06-2019', number: 12, cost: 5, description: 'Phone'},
					{date: '12-06-2019', number: 12, cost: 5, description: 'Phone'},
					{date: '12-06-2019', number: 12, cost: 5, description: 'Phone'}
				]
			},
			{
				cardNumber: 'visa-4447', balance: 7, expense: 52, block: true,
				payments: [
					{date: '12-06-2019', number: 12, cost: 5, description: 'Phone'},
					{date: '12-06-2019', number: 12, cost: 5, description: 'Phone'},
					{date: '12-06-2019', number: 12, cost: 5, description: 'Phone'}
				]
			},
			{
				cardNumber: 'visa-4449', balance: 9, expense: 62, block: false,
				payments: [
					{date: '12-06-2019', number: 12, cost: 5, description: 'Phone'},
					{date: '12-06-2019', number: 12, cost: 5, description: 'Phone'},
					{date: '12-06-2019', number: 12, cost: 5, description: 'Phone'}
				]
			}
		];


		console.log(data);
		this.setState({
			isLoading: false,
			data: data,
			sort: 'asc',  // 'desc'
			sortField: 'id',
			cmp: 'allCardsTable'
		});
	}

	onSort = sortField => {
		const cloneData = this.state.data.concat(); // save state.data
		const sortType = this.state.sort === 'asc' ? 'desc' : 'asc'; // generate type
		const orderedData = sort.orderBy(cloneData, sortField, sortType); // generate data

		this.setState({
			data: orderedData,
			sort: sortType,
			sortField
		});


	};

	onRowSelect = row => (
		this.setState({row: row, cmp:'selectedCardHistory'})
	);
	cardsList = row => (
		this.setState({row: null, cmp:'allCardsTable'})
	);
	openIncome = incomeModalOn => (
		this.setState({incomeModalOn: true, cmp:'openIncomeWindow'})
	);
	closeModal = incomeModalOn => (
		this.setState({incomeModalOn: false, cmp:'allCardsTable'})
	);
	setCardNumber = selectedCardNumber => {
		this.setState({selectedCardNumber});
	};
	setValue = costValue => {
		this.setState({costValue: costValue.target.value});
	};
	setDescription= description => {
		this.setState({description: description.target.value});
	};
	newPayment=()=>(
		this.setState({newPaymentModalOn: true, cmp:'openPaymentWindow'})
	)
	render() {
		let component = null;

		switch (this.state.cmp){
			case 'Loader':
				component = <Loader/> //data loading case
				break;
			case 'allCardsTable':
				component = <Table //data load case
					data={this.state.data}
					sort={this.state.sort} //auto sort
					sortField={this.state.sortField} // sort field
					onSort={this.onSort} // sort (ASK MENTOR! without rest)
					onRowSelect={this.onRowSelect} //info about card payment
				/>
				break;
			case 'selectedCardHistory':
				component = <PaymentTable
					data={this.state.row.payments}
					sort={this.state.sort} //auto sort
					sortField={this.state.sortField} // sort field
					onSort={this.onSort} // sort (ASK MENTOR! without rest)
					onRowSelect={this.onRowSelect} //info about card payment
				/>
				break;
			case 'openIncomeWindow':
				component = <Income
					closeModal={this.closeModal}
					data={this.state.data}
					card={this.state.selectedCardNumber}
					costValue={this.state.costValue}
					setCardNumber={this.setCardNumber}
					setValue={this.setValue}
				/>
				break;
			case 'openPaymentWindow':
				component = <Payment
					closeModal={this.closeModal}
					data={this.state.data}
					card={this.state.selectedCardNumber}
					costValue={this.state.costValue}
					setCardNumber={this.setCardNumber}
					setValue={this.setValue}
					setDescription={this.setDescription}
				/>
				break;
		}
		return (
			<div className="container">

				<Header
					cardsList={this.cardsList}
					openIncome={this.openIncome}
					newPayment = {this.newPayment}
				/>
				<React.Fragment>
					<div>
						{component}
					</div>
				</React.Fragment>

			</div>

		);
	}

}

export default App;